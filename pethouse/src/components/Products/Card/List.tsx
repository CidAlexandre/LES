import React from "react";
import { ProductCard } from "./Card";

export function ProductsList({ loading, products }: any) {
  if (loading) {
    return (
      <div className="spinner-border text-secondary" role="status">
        <span className="visually-hidden">Loading...</span>
      </div>
    );
  }
  return (
    <div className="row">
      <div className="col-sm-3">
        {products?.map((product: any) => (
          <ProductCard product={product} />
        ))}
      </div>
    </div>
  );
}
