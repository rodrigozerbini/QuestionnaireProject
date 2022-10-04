import './App.css';
import * as React from 'react';

function App() {

  const [preguntas,setPreguntas]=React.useState()
  const [preguntaIndex, setPreguntaIndex] = React.useState(0)

  React.useEffect(()=>{
    fetch("http://localhost:8080/questions/next")
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
    }

  return (
    <div className="App">
        <form>
            <p>{preguntas ? 
                preguntas[preguntaIndex].text :
                "Loading..."
              }
            </p>
            <select>
              <option>SI</option>
              <option>NO</option>
            </select>
        </form>
        <button type='submit' onClick={() => goNext()}>NEXT</button>
    </div>
  );
}

export default App;
