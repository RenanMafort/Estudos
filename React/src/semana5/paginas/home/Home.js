import {Link} from "react-router-dom";

function inicio() {
    return (
        <div>
            <h1>HOME</h1>
            <Link to="/">Home</Link><br/>
            <Link to="/sobre">Sobre</Link><br/>
            <Link to="/Contato">Contato</Link><br/>
        </div>
    );
}

export default inicio