import './App.css';

const element = <h1>Heello,World</h1>

function inicio() {
  return (
      <div>
        Heelo world!
          {element} {/* constante element*/}
     <Arrow nome="Renan" sobreNome="Sereia"></Arrow> {/* 'nome' e 'Sobreno' poderia ser qualquer outro nome*/}
      </div>
  );
}

// Arrow Function
// Deve ser retorando apenas uma tag que encapsula outras
const Arrow = (props) => {
  return (
      <div className="estilo"> {/* class no CSS*/}
          <label>{props.nome}</label><br/>
          <label>{props.sobreNome}</label>
      </div>
  );
}

export default inicio;
