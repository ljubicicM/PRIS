/* eslint-disable eqeqeq */
import { useContext, useState } from 'react';
import { Button } from '../components/buttonComponent/Button';
import { PasswordField } from '../components/passwordFieldComponent/password';
import { Textfield } from '../components/textFieldComponent/textfield';
import './styles/loginRegisterPage.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { Context } from '../context';

export const LoginPage = () => {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    const { userId, setUserType, setUserId, setIsNavBarVisible } = useContext(Context) as any;
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
        axios.get('http://localhost:8082/user/login?' +
            'email=' + email +
            '&password=' + password).then((response) => {
                if (response.data.id != null && response.data.id != "" && response.data.id != undefined) {
                    switch (response.data.roleUser) {
                        case 'Turista':
                            setUserType('tourist');
                            setUserId(response.data.id);
                            break;
                        case 'Vodič':
                            setUserType('guide');
                            setUserId(response.data.id);
                            break;
                        case 'Admin':
                            setUserType('admin');
                            setUserId(response.data.id);
                            break;
                        default:
                            setUserType('');
                            setUserId('');
                            break;
                    }
                    setIsNavBarVisible(true);
                    navigate('/');
                } else {
                    alert('Wrong email or password');
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