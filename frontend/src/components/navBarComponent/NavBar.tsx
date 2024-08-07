import { useNavigate } from 'react-router-dom';
import './style.css';


export const NavBar = () => {
    const navigate = useNavigate();
    var elements = [];
    elements = (() => {
        switch (localStorage.getItem('userType')) {
            case "":
                return [{ label: "Home Page", url: "/" }, { label: "Register", url: "/register" }, { label: "Login", url: "/login" },
                { label: "Create Route", url: "/cr/searchby" }, { label: "Saved Routes", url: "/savedroutes" }];
            case "tourist":
                return [{ label: "Home Page", url: "/" }, { label: "Create Route", url: "/cr/searchby" }, { label: "Saved Routes", url: "/savedroutes" }, { label: "Logout", url: "/logout" }];
            case "guide":
                return [{ label: "Home Page", url: "/" }, { label: "Add Art Piece", url: "/save/artpiece" }, { label: "Add Epoch", url: "/save/epoch" },
                { label: "Add Author", url: "/save/author" }, { label: "Add Artistic Movement", url: "/save/artisticmovement" }, { label: "Update Text", url: "/update" },
                { label: "Logout", url: "/logout" }];
            case "admin":
                return [{ label: "Home Page", url: "/" }, { label: "Add Art Piece", url: "/save/artpiece" }, { label: "Add Epoch", url: "/save/epoch" },
                { label: "Add Author", url: "/save/author" }, { label: "Add Artistic Movement", url: "/save/artisticmovement" },
                { label: "Create Route", url: "/cr/searchby" }, { label: "Saved Routes", url: "/savedroutes" }, { label: "Update Text", url: "/update" },
                { label: "Approve Guide", url: "/approveguide" }, { label: "Logout", url: "/logout" }];
            default:
                return [];
        }
    })();

    const handleClick = (url: string) => {
        if (url === '/login' || url === '/register') {
            navigate(url);
        } else {
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