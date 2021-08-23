import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";

import { ProductsList } from "../Card/List";

import "bootstrap/dist/css/bootstrap.min.css";

interface Products {
  productId: string;
  productName: string;
  productAmount: string;
  productImageUrl: string;
}

export function ProductSearch() {
  const [products, setProducts] = useState<[Products]>();
  const [search, setSearch] = useState('');

  useEffect(() => {
    const params={}as any ;
    if(search){
      params.title_like = search;
    }

    axios.get("http://localhost:8000/list-products", {params})
      .then((response) => {
        setProducts(response.data);
    });
  }, [search]);

  return (
    <div className="container-fluid">
        <div >
            <input
              className="form-control-lg" 
              type="search"
              placeholder = "Buscar"
              value= {search}
              onChange={(ev)=> setSearch(ev.target.value)}
            />
        </div>
      <div>
        <ProductsList loading = {!products?.length} products = {products} />
      </div>
    </div>
  );
}
