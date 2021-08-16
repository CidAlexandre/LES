import { Button } from 'components/Button';
import 'styles/registry.scss';

export function Registry(){
    return(
        <div id = "page-registry">
            <div className="container">
                <main>
                    Criar seu cadastro
                    <p className = "p1">Veja seus pedidos e faça compras de forma rápida e fácil</p>

                </main>
                <form>
                    <div>
                    <label>Nome: </label>
                    <input
                        type="text"
                        id = "fname"
                        placeholder="Digite seu nome"
                        required
                    />
                    </div>

                    <div>
                    <label>Sobrenome: </label>
                    <input
                        type="text"
                        id = "sname"
                        placeholder="Digite seu sobrenome"
                        required
                    />
                    </div>

                    <div>
                    <label>Data de nascimento</label>
                    <input 
                    type="date" 
                    required
                    />
                    </div>

                    <div>
                    <label>CPF</label>
                    <input 
                    type="text"
                    placeholder="___-___-___-__"
                    pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}"
                    required
                    />
                    </div>
                   
                    <div>
                    <label>Telefone</label>
                    <input 
                    type="tel"
                    placeholder="(xx)xxxxx-xxxx"
                    pattern="[0-9]({2})[0-9]{5}-[0-9]{4}"
                    required
                    />
                    </div>

                    <div>
                    <label>E-mail</label>
                    <input 
                    type="email" 
                    id="email"
                    required
                    />
                    </div>

                    <div>
                    <label>Senha</label>
                    <input 
                    type="password" 
                    id="password"
                    required
                    />
                    </div>

                    <div>
                    <label>Confirmação da senha</label>
                    <input 
                    type="password" 
                    id="confirmPassword"
                    required
                    />
                    </div>

                    <Button type="submit">Salvar</Button>
                </form>
            </div>
        </div>
    )
}