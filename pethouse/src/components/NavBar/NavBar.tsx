import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css'
import logo from 'assets/images/logo.svg';
import { Link } from "react-router-dom";

export function NavBar(){
    
    return(
        <nav className="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <Link className="navbar-brand" to="/" >
                <img src={logo} width="75"
                    className="rounded"
                    alt="logo pet-house"
                />
            </Link>
        </nav>
    )

}