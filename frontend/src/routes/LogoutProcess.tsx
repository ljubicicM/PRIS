import { useNavigate } from "react-router-dom";

export const LogoutProcess = () => {
    const navigate = useNavigate();
    const handleLogout = async () => {
        await localStorage.setItem('userId', '');
        await localStorage.setItem('userType', '');
        await navigate('/');
    }
    handleLogout();

    return (<></>);
}