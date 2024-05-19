import { useState } from 'react';
import { Button } from '../components/buttonComponent/Button';
import { PasswordField } from '../components/passwordFieldComponent/password';
import { Textfield } from '../components/textFieldComponent/textfield';
import { RadioButtons } from '../components/radioButtonComponent/RadioButtons';
import './styles/loginRegisterPage.css';

export const RegisterPage = () => {
    const [password, setPassword] = useState("");
    const [repeatPassword, setRepeatPassword] = useState("");
    const [email, setEmail] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [username, setUsername] = useState("");

    const checkEmail = () => {
        return email.includes('@') && email.includes('.')
    }
    const checkPassword = () => {
        return (password === repeatPassword && password.length > 0)
    }

    return (
        <div className='register-container-outer'>
            <div className='register-container'>
                <h1>Register</h1>
                <RadioButtons labels={["Turista", "Vodič"]} name='accountType' />
                <Textfield value={username} setValue={setUsername} size='medium' placeholder="username" headerText="User Name" />
                <Textfield value={phoneNumber} setValue={setPhoneNumber} size='medium' placeholder="phone number" headerText="Phone Number" />
                <Textfield value={email} setValue={setEmail} size='medium' placeholder="email" headerText="Email" />
                <PasswordField value={password} setValue={setPassword} placeholder="************" header="Password" />
                <PasswordField value={repeatPassword} setValue={setRepeatPassword} placeholder="************" header="Confirm Password" />
                <Button isEnabeld={checkPassword() && checkEmail()} label="Register" onClick={() => { alert('Register') }} size='large' />
            </div>
        </div>
    );
}