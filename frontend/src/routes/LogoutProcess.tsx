import { useContext } from "react";
import { Context } from "../context";
import { useNavigate } from "react-router-dom";

export const LogoutProcess = () => {
    const navigate = useNavigate();
    const { setUserType, setUserId, setIsNavBarVisible } = useContext(Context) as any;
    setUserType('');
    setUserId('');
    setIsNavBarVisible(true);
    navigate('/');
    return (<></>);
}