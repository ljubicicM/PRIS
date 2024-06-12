import React from "react";
import "./style.css";

declare interface CheckboxProps {
    name: string;
    val: boolean;
    setValue: any;
    label: string;
}

export const Checkbox = ({ name, val, setValue, label }: CheckboxProps) => {
    return (
        <div className="checkbox">
            <input
                className="checkbox-input"
                type="checkbox"
                name={name}
                checked={val}
                onChange={() => {
                    setValue(!val);
                }}
            />
            <div className="checkbox-label">
                {label}
            </div>
        </div>
    );
};
