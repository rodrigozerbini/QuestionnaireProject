import './App.css';
import * as React from 'react';

function App() {

  const [preguntas,setPreguntas]=React.useState()
  const [preguntaIndex, setPreguntaIndex] = React.useState(0)
  const [respuestas, setRespuestas]=React.useState([])

  React.useEffect(()=>{
    fetch("http://localhost:8080/questions")
    .then(res=>res.json())
    .then((result)=>{
      console.log(result)
        setPreguntas(result);
    }
)},[])

    const goNext = () => {
      if (preguntaIndex !== preguntas.length - 1){
        setPreguntaIndex(preguntaIndex + 1)
      }

      let answer = document.querySelector('input[name="option"]:checked').value;
      if (answer) {
        let newRespuestas = [...respuestas]
        newRespuestas[preguntaIndex] = answer
        setRespuestas(newRespuestas)
      }

      //TODO: enviar al server con POST
      // fetch(url, {
      //   method: 'POST',
      //   body: JSON.stringify(data)})
    }

    


  return (
    <div className="App">
        <p>{preguntas ? 
            preguntas[preguntaIndex].text :
            "Loading..."
          }
        </p>

        <form id='form1'>
            <label>
              SI
              <input type="radio" value="si" name='option' />
            </label>
            <label>
              NO
              <input type="radio" value="no" name='option' />
            </label>
            
        </form>
        <button type='submit' onClick={() => goNext()}>NEXT</button>
    </div>
  );
}

export default App;
