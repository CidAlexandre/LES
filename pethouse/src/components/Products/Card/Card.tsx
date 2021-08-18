import "styles/card.scss";

export function ProductCard({ product }: any) {
  return (
    <div id="card">
      <img
        className="card-img"
        src={product.productImageUrl}
        alt={product.productName}
      />
      <div>
        <h2>
          <b>{product.productName}</b>
        </h2>

        <span className="price"> R$ {product.productAmount} </span>
      </div>
    </div>
  );
}
