import HomePage from "./HomePage";
import RoleList from "./RoleList";
import Login from './Pages/Login';
import { Route, Switch } from 'react-router-dom';



function App() {
    return (
        <div className={App}>

                <HomePage />
                <RoleList />
                {/*<Login/>*/}


        </div>
    );
}

export default App;
