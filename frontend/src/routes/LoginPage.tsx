import { useState } from 'react';
import { Button } from '../components/buttonComponent/Button';
import { PasswordField } from '../components/passwordFieldComponent/password';
import { Textfield } from '../components/textFieldComponent/textfield';
import './styles/loginRegisterPage.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export const LoginPage = () => {
    const navigate = useNavigate();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const checkEmail = () => {
        return email.includes('@') && email.includes('.')
    }
    const checkPassword = () => {
        return (password.length > 0)
    }
    const handleLogin = () => {
        axios.post('http://localhost:8082/user/login', {
            passwordUser: password as string,
            emailUser: email as string,
        }).then((response) => {
            if (response.data) {
                navigate('/login');
            }
        }).catch((error) => {
            console.log(error)
        })
    }

    return (
        <div className='login-container-outer'>
            <div className='login-container'>
                <h1>Log in</h1>
                <Textfield value={email} setValue={setEmail} size='medium' placeholder="email" headerText="Email" />
                <PasswordField value={password} setValue={setPassword} placeholder="************" header="Password" />
                <Button isEnabeld={checkPassword() && checkEmail()} label="Log in" onClick={() => handleLogin()} size='large' />
            </div>
        </div>
    );
}