import './App.css';
import {Component} from "react";

class App extends Component{

    constructor(props) {
        super(props);
        this.state = { // Onde armazena as variaveis
            nome: "Renan Sereia",
            email: "",
            feed: [
                {id:1, username:"Renan",curtida:20, comentarios:2},
                {id:2, username:"Mafort",curtida:20, comentarios:2},
                {id:3, username:"Sereia",curtida:20, comentarios:2},
            ]
        }

    }

    muda(event){
        let state = this.state;
        state.email = event.target.value;
        this.setState(state);
    }


    render() { //Obrigatorio ter esse metodo em classes
     return (
         <div>
             <input type="text" size="20" name="email" onChange={(e) => this.muda(e)}/><br/>
             <label>{this.state.email}</label>
         </div>
     );
       //  this.state.feed.map(item => {
       //     return (
       //
       //       // <div key={item.id}>
       //       //     {item.username}
       //       // </div>
       //     );
       // })
    }

}

export default App;