import { useState } from "react";
import "./style.css";
import imageHidden from "../../assets/images/passwordHidden.svg";
import imageVisible from "../../assets/images/passwordVisable.svg";

declare interface PasswordProps {
    placeholder: string;
    header?: string;
    className?: string;
    value?: string;
    setValue?: any;
}

export const PasswordField = ({ placeholder, header, className, value, setValue }: PasswordProps) => {
    const [showPassword, setShowPassword] = useState(false);
    const [type, setType] = useState("password");

    const handleVisibility = () => {
        setShowPassword(!showPassword);
        setType(showPassword ? "password" : "text");
    }


    return (
        <div>
            <p className="password-header">{header}</p>
            <label className={"password-container " + className}>
                <input className="fieldP " value={value} onChange={e => setValue(e.target.value)} type={type} placeholder={placeholder}></input>
                <img className="password-img" src={showPassword ? imageVisible : imageHidden}
                    onClick={() => handleVisibility()} alt=""></img>
            </label >
        </div >
    );
}