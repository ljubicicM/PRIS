import { Button } from '../components/buttonComponent/Button';

export const RegisterPage = () => {
    return (
        <div>
            <h1>Register</h1>
            <Button label="Register" onClick={() => alert('Register')} />
        </div>
    );
}