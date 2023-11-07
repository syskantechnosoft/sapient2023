import logo from './logo.svg';
import './App.css';
import Siva from './Siva';
import Hello from './Hello';
import HelloMessage from './HelloMessage';
import Counter from './Counter';
import Alert from './Alert';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload - Modified it.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <Hello/>
        <HelloMessage message="welcome to props" address = "bangalore" name="ABCD"/>
        <Counter/>
        <Alert/>
      </header>
      
    </div>
  );
}

export default App;
