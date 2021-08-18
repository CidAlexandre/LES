import React from "react";
import { Button } from "components/Button";
import "styles/registry.scss";
import "bootstrap/dist/css/bootstrap.min.css";

export function Registry() {
  return (
    <div id="page-registry">
      <div className=".container-fluid">
        <main>
          Criar seu cadastro
          <p className="p1">
            Veja seus pedidos e faça compras de forma rápida e fácil
          </p>
        </main>
        <form>
          <div>
            Nome
            <input
              type="text"
              id="fname"
              placeholder="Digite seu nome"
              required
            />
          </div>

          <div>
            Sobrenome
            <input
              type="text"
              id="sname"
              placeholder="Digite seu sobrenome"
              required
            />
          </div>

          <div>
            Data de nascimento
            <input type="date" id="birthDate" required />
          </div>

          <div>
            CPF
            <input
              type="text"
              id="cpf"
              placeholder="___-___-___-__"
              pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}"
              required
            />
          </div>

          <div>
            Tipo de telefone
            <select id="typePhone" required>
              <option>Celular</option>
              <option>Residencial</option>
              <option>Comercial</option>
            </select>
          </div>

          <div>
            Telefone
            <input
              type="tel"
              id="phoneNumber"
              placeholder="(xx)xxxxx-xxxx"
              pattern="[0-9]({2})[0-9]{5}-[0-9]{4}"
              required
            />
          </div>

          <div>
            CEP
            <input
              type="text"
              id="cep"
              placeholder="_____-___"
              pattern="[0-9]{5}.[0-9]{3}"
              required
            />
          </div>

          <div>
            Endereço
            <input
              type="text"
              id="address"
              placeholder="Digite seu endereço"
              required
            />
          </div>
          <div>
            Número
            <input
              type="text"
              id="addressNumber"
              placeholder="Digite o número do endereço"
              required
            />
          </div>

          <div>
            Complemento
            <input type="text" id="complement" placeholder="ex. casa 2" />
          </div>

          <div>
            Bairro
            <input
              type="text"
              id="neighbor"
              placeholder="Digite seu bairro"
              required
            />
          </div>

          <div>
            Cidade
            <input
              type="text"
              id="city"
              placeholder="Digite sua cidade"
              required
            />
          </div>

          <div>
            Estado
            <input
              type="text"
              id="state"
              placeholder="Digite seu estado"
              required
            />
          </div>

          <div>
            E-mail
            <input
              type="email"
              id="email"
              placeholder="Digite seu e-mail"
              required
            />
          </div>

          <div>
            Senha
            <input
              type="password"
              id="password"
              placeholder="Digite sua senha"
              required
            />
          </div>

          <div>
            Confirmação da senha
            <input
              type="password"
              id="confirmPassword"
              placeholder="Confirme sua senha"
              required
            />
          </div>

          <Button type="submit">Salvar</Button>
        </form>
      </div>
    </div>
  );
}
