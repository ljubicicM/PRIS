import { useState } from 'react';
import { Button } from '../components/buttonComponent/Button';
import { PasswordField } from '../components/passwordFieldComponent/password';
import { Textfield } from '../components/textFieldComponent/textfield';
import { RadioButtons } from '../components/radioButtonComponent/RadioButtons';

export const RegisterPage = () => {
    const [password, setPassword] = useState("");
    const [repeatPassword, setRepeatPassword] = useState("");
    const checkPassword = () => {
        return (password === repeatPassword && password.length > 0)
    }

    return (
        <div>
            <h1>Register</h1>
            <RadioButtons labels={["Turista", "Vodič"]} name='accountType' />
            <Textfield size='medium' placeholder="email" headerText="Email" />
            <PasswordField value={password} setValue={setPassword} placeholder="************" header="Password" />
            <PasswordField value={repeatPassword} setValue={setRepeatPassword} placeholder="************" header="Confirm Password" />
            <Button label="Register" onClick={() => alert('Register')} />
        </div>
    );
}