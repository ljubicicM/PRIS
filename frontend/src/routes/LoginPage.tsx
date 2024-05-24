import { useState } from 'react';
import { Button } from '../components/buttonComponent/Button';
import { PasswordField } from '../components/passwordFieldComponent/password';
import { Textfield } from '../components/textFieldComponent/textfield';
import './styles/loginRegisterPage.css';

export const LoginPage = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const checkEmail = () => {
        return email.includes('@') && email.includes('.')
    }
    const checkPassword = () => {
        return (password.length > 0)
    }

    const handleLogin = () => {

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