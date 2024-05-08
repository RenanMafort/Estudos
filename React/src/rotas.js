import {BrowserRouter, Route, Routes} from "react-router-dom";

import Formulario from "./semana8/Formulario";
import Login from "./semana8/Login";
import Home from "./semana8/Home";

const Rotas = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route exact path="/cadastro" element={<Formulario/>} />
                <Route exact path="/" element={<Login />} />
                <Route exact path="/home" element={<Home />} />
            </Routes>
        </BrowserRouter>
    );
}

export default Rotas