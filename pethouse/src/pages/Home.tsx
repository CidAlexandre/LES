import { ProductSearch } from "components/Products/Search/Search";
import { NavBar } from "components/NavBar/NavBar";

import 'bootstrap/dist/css/bootstrap.min.css'

export function Home() {
  return (
  <div id="page-registry">
      <div>
        <header>
          <NavBar />
        </header>
      </div>
      <div>
        <main >
          <ProductSearch />
        </main>
      </div>
    </div>
  );
}
