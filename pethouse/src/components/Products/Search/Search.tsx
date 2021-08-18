import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";

import { ProductCard } from "../Card/Card";

import "bootstrap/dist/css/bootstrap.min.css";

interface Products {
  productId: string;
  productName: string;
  productAmount: string;
  productImageUrl: string;
}

export function ProductSearch() {
  const [products, setProducts] = useState<[Products]>();

  useEffect(() => {
    axios.get("http://localhost:8000/list-products").then((response) => {
      setProducts(response.data);
    });
  }, []);

  return (
    <div>
        <header>
            <input type="search"/>
        </header>
      <div>
        {products?.map((product) => (
          <ProductCard product={product} />
        ))}
      </div>
    </div>
  );
}
