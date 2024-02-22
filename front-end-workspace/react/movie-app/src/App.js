import logo from './logo.svg';
import './App.css';
import Potato from './Potato';
// function Food(props){
//   return <h1>I love sweetPoatao.</h1>
// }
function Food(props) {
  return(
  <div>
    <h1>I love {props.name}.</h1>
    <img src ={props.picture} /> 
  </div>
  );
  // return <h1>I love {props.fav}.</h1>
  // // <img src = /> 
}
const foodILike = [
  {
    name: 'potato',
    image: 'https://place-hold.it/200x100/'
  },
  {
    name: 'apple',
    image: 'https://place-hold.it/200x1700/'
  }
]
function App() { //main - 모여있음
  return (
    <div>
      <h1>hello react</h1>
      {/* 
      <Potato />
      <Food /> 
      =======================
      <Food fav="potato" />
      <Food fav="sweet potato" />
      */}
      {foodILike.map((fruit) => (
       /* <Food fav={fruit.name} /> */
      <Food name={fruit.name} picture ={fruit.image}/>
      ))}
    </div>
  );
}

export default App;
