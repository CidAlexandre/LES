import { Link } from 'react-router-dom';
import logoImg from 'assets/images/logo.svg';

import { Button } from 'components/Button';

import 'styles/auth.scss'
export function Login(){
    return(
        <div id = "page-auth">
            <aside>
                <img src={logoImg} alt="PetHouse logomark"/>
            </aside>
            <main>
                <div className="main-content">
                    <form>
                        <input type = "email"
                        placeholder = "Digite seu e-mail"
                        autoFocus
                        />
                       
                       <input
                        type = "password"
                        placeholder = "Digite sua senha"
                        />
                       
                        <Button type="submit" >Entrar</Button>
                    </form>
                    
                    <Link to="#">Esqueceu sua senha?</Link>
                    <Link to= "/registry/new">Ainda não tem cadastro?</Link>

                </div>
            </main>
        </div>
    )
}