import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";

import { Button } from "../../components/Button";
import "styles/registry.scss";

interface Address {
  cep: string;
  street: string;
  number: string;
  neighbor: string;
  complement: string;
  city: string;
  state: string;
}

interface Phone {
  typePhone: string;
  phoneNumber: string;
}

interface Card {
  owner: string;
  code: string;
  vatliThru: Date;
}

interface User {
  firstName: string;
  lastName: string;
  address: Array<Address>;
  phone: Array<Phone>;
  card: Array<Card>;
  status: boolean;
}

export function Update() {
  /*
    const url = "http://localhost:8000/users/{id}"

    const [address, setAddress] = useState<Address>();
    const addressResponse = useEffect(()=> {
        axios.get("${url}/list-address")
            .then((response)=> {
                setAddress(response.data)})
    })


    const [phone, setPhone] = useState<Phone>();
    const phoneResponse = useEffect(()=>{
        axios.get("${url}/list-phone")
            .then((response) => {
                setPhone(response.data)
            })
    })

    const [card, setCard] = useState<Card>();
    const cardResponse = useEffect(()=>{
        axios.get("${url}/list-card")
            .then((response)=>{
                setCard(response.data)
            })
    })
 
    const [userUpdate, setUserUpdate] = useState<User>();
    const userResponse = useEffect(()=>{
        axios.get("${url}/update")
    })

    useEffect(() => {
        axios.post("${url}/update")
    })
*/
  return (
    <div id="page-registry">
      <div className=".container-fluid">
        <div className="dropdown">
          <main id="phone">
            <p className="p1">Atualização do telefone</p>
          </main>

          <form>
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
              <Button>Adicionar telefone</Button>
              <Button>Atualizar telefone</Button>
            </div>
          </form>
        </div>

        <div>
          <main>
            <p className="p1">Atualização do endereço</p>
          </main>

          <form>
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
              <Button>Adicionar endereço</Button>
              <Button>Atualizar endereço</Button>
            </div>
          </form>
        </div>

        <div id="cards">
          <main>
            <p className="p1">Atualização do cartão</p>
          </main>

          <form>
            <div>
              Titular do cartão
              <input
                type="text"
                id="owner"
                placeholder="Digite o nome do titular"
                required
              />
            </div>

            <div>
              Número do cartão
              <input
                type="text"
                id="code"
                placeholder="____ _____ _____ _____"
                pattern="[0-9]{4}[0-9]{4}-[0-9]{4}-[0-9]{4}"
                required
              />
            </div>

            <div>
              Válidade do cartão
              <input
                type="month"
                id="validThru"
                placeholder="MM/YYYY"
                required
              />
            </div>

            <div>
              <Button>Adicionar cartão</Button>
              <Button>Atualizar cartão</Button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}
