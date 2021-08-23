import React from "react";
import { Button } from "components/Button";
import "styles/registry.scss";
import "bootstrap/dist/css/bootstrap.min.css";
import { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";

const initialValue = {
  fName: "",
  sName: "",
  birthDate: Date,
  cpf: "",
  typePhone: "",
  phoneNumber: "",
  cep: "",
  address: "",
  addresNumber: "",
  complement: "",
  neighbor: "",
  city: "",
  state: "",
  email: "",
  password: "",
  confirmPassword: "",
};

export function Registry() {
  const [values, setValues] = useState(initialValue);

  const history = useHistory();

  function onChange(ev : any) {
    const { name, value } = ev.target;
    setValues({...values, [name] : value});
  }

  function onSubmit(ev : any){
    ev.preventDefault();
    axios.post('http://localhost:8000/create-user', values)
    .then((response) => {
      history.push("/");
    });
  }

  return (
    <div id="page-registry">
      <div className=".container-fluid">
        <main>
          Criar seu cadastro
          <p className="p1">
            Veja seus pedidos e faça compras de forma rápida e fácil
          </p>
        </main>
        <form onSubmit={onSubmit}> 
          <div>
            Nome
            <input
              type="text"
              id="fName"
              name="fName"
              placeholder="Digite seu nome"
              onChange={onChange}
              required
            />
          </div>

          <div>
            Sobrenome
            <input
              type="text"
              id="sName"
              name="sName"
              placeholder="Digite seu sobrenome"
              onChange={onChange}
              required
            />
          </div>

          <div>
            Data de nascimento
            <input
              type="date"
              id="birthDate"
              name="birthDate"
              onChange={onChange}
              required
            />
          </div>

          <div>
            CPF
            <input
              type="text"
              id="cpf"
              name="cpf"
              onChange={onChange}
              placeholder="___-___-___-__"
              pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}"
              required
            />
          </div>

          <div>
            Tipo de telefone
            <select
              id="typePhone"
              name="typePhone"
              onChange={onChange}
              required
            >
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
              name="phoneNumber"
              onChange={onChange}
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
              name="cep"
              onChange={onChange}
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
              name="address"
              onChange={onChange}
              placeholder="Digite seu endereço"
              required
            />
          </div>
          <div>
            Número
            <input
              type="text"
              id="addressNumber"
              name="addressNumber"
              onChange={onChange}
              placeholder="Digite o número do endereço"
              required
            />
          </div>

          <div>
            Complemento
            <input
              type="text"
              id="complement"
              name="complement"
              onChange={onChange}
              placeholder="ex. casa 2"
            />
          </div>

          <div>
            Bairro
            <input
              type="text"
              id="neighbor"
              name="neighbor"
              onChange={onChange}
              placeholder="Digite seu bairro"
              required
            />
          </div>

          <div>
            Cidade
            <input
              type="text"
              id="city"
              name="city"
              onChange={onChange}
              placeholder="Digite sua cidade"
              required
            />
          </div>

          <div>
            Estado
            <input
              type="text"
              id="state"
              name="state"
              onChange={onChange}
              placeholder="Digite seu estado"
              required
            />
          </div>

          <div>
            E-mail
            <input
              type="email"
              id="email"
              name="email"
              onChange={onChange}
              placeholder="Digite seu e-mail"
              required
            />
          </div>

          <div>
            Senha
            <input
              type="password"
              id="password"
              name="password"
              onChange={onChange}
              placeholder="Digite sua senha"
              required
            />
          </div>

          <div>
            Confirmação da senha
            <input
              type="password"
              id="confirmPassword"
              name="confirmPassword"
              onChange={onChange}
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
