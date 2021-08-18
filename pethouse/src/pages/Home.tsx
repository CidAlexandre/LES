import { ProductSearch } from "components/Products/Search/Search";
import { NavBar } from "components/NavBar/NavBar";

export function Home() {
  return (
    <div>
      <NavBar />
      <div>
        <ProductSearch />
      </div>
    </div>
  );
}
