import { createContext, useState } from 'react';

import { BrowserRouter, Route} from 'react-router-dom';

import { Registry } from "pages/users/Registry";
import { Login } from "pages/users/Login";
import { Home } from 'pages/Home';
import { Update } from 'pages/users/Update';

export const Context = createContext( {} as any );

function App(){

  const [ value, setValue ] = useState();
  
  return (
    <BrowserRouter>
      <Context.Provider value = { { value, setValue } }></Context.Provider>
        <Route path= "/" exact component={ Home }/>
        <Route path= "/users/login"  component={ Login }/>
        <Route path= "/users/new" component={ Registry }/>
        <Route path= "/users/update" component={ Update } />

    </BrowserRouter>
  )
}

export default App;
