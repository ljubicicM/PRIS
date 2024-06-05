import { useNavigate } from 'react-router-dom';
import './style.css';
import { useContext } from 'react';
import { Context } from '../../context';


export const NavBar = () => {
    const { userType, isNavBarVisible, setIsNavBarVisible } = useContext(Context) as any;
    const navigate = useNavigate();
    var elements = [];
    if (!isNavBarVisible) { return (<div></div>); }
    else {
        elements = (() => {
            switch (userType) {
                case "":
                    return [{ label: "Register", url: "/register" }, { label: "Login", url: "/login" }];
                case "tourist":
                    return [{ label: "Profile", url: "/profile" }, { label: "Logout", url: "/logout" }];
                case "guide":
                    return [{ label: "Profile", url: "/profile" }, { label: "Logout", url: "/logout" }];
                case "admin":
                    return [{ label: "Admin", url: "/admin" }, { label: "Logout", url: "/logout" }];
                default:
                    return [];
            }
        })();
    }
    const handleClick = (url: string) => {
        if (url === '/login' || url === '/register') {
            setIsNavBarVisible(false);
            navigate(url);
        } else {
            setIsNavBarVisible(true);
            navigate(url);
        }
    };
    const children = elements.map((element, index) => {
        return (
            <div className='nav-bar-item' onClick={() => handleClick(element.url)} key={index} >
                <h1 className='nav-bar-link'  >{element.label}</h1>
            </div>
        )
    });
    return (
        <div className='nav-bar-container'>
            {children}
        </div>
    )
}