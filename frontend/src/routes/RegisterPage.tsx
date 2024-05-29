import { useState } from 'react';
import { Button } from '../components/buttonComponent/Button';
import { PasswordField } from '../components/passwordFieldComponent/password';
import { Textfield } from '../components/textFieldComponent/textfield';
import { RadioButtons } from '../components/radioButtonComponent/RadioButtons';
import './styles/loginRegisterPage.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export const RegisterPage = () => {
    const navigate = useNavigate();
    const [password, setPassword] = useState("");
    const [repeatPassword, setRepeatPassword] = useState("");
    const [email, setEmail] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [username, setUsername] = useState("");
    const [radioValue, setRadioValue] = useState("");

    const checkEmail = () => {
        return email.includes('@') && email.includes('.')
    }
    const checkPassword = () => {
        return (password === repeatPassword && password.length > 0)
    }

    const handleRegister = () => {
        axios.post('http://localhost:8082/user/register', {
            usernameUser: username as string,
            passwordUser: password as string,
            emailUser: email as string,
            phoneUser: phoneNumber as string,
            roleUser: radioValue as string
        }).then((response) => {
            if (response.data) {
                navigate('/login');
            }
        }).catch((error) => {
            console.log(error)
        })
    }

    return (
        <div className='register-container-outer'>
            <div className='register-container'>
                <h1>Register</h1>
                <RadioButtons labels={["Turista", "Vodič"]} name='accountType' setValue={setRadioValue} />
                <Textfield value={username} setValue={setUsername} size='medium' placeholder="username" headerText="User Name" />
                <Textfield value={phoneNumber} setValue={setPhoneNumber} size='medium' placeholder="phone number" headerText="Phone Number" />
                <Textfield value={email} setValue={setEmail} size='medium' placeholder="email" headerText="Email" />
                <PasswordField value={password} setValue={setPassword} placeholder="************" header="Password" />
                <PasswordField value={repeatPassword} setValue={setRepeatPassword} placeholder="************" header="Confirm Password" />
                <Button isEnabeld={checkPassword() && checkEmail()} label="Register" onClick={() => handleRegister()} size='large' />
            </div>
        </div>
    );
}