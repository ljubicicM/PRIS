import { useNavigate } from 'react-router-dom';
import './style.css';
import { useContext } from 'react';
import { Context } from '../../context';


declare interface NavBarProps {
    elements?: Array<NavBarElement>;
}

declare interface NavBarElement {
    label: string;
    url: string;
}

export const NavBar = ({ elements = [] }: NavBarProps) => {
    const [userType] = useContext(Context) as any;
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
    console.log(elements);
    const navigate = useNavigate();
    const handleClick = (url: string) => {
        navigate(url);
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