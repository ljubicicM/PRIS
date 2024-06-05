
import React from 'react';
import './style.css';
declare type Option = {
    id: number;
    value: string;
}

declare interface DropdownProps {
    headerText: string;
    value: any;
    setValue: any;
    options: Array<Option>;
}


export const Dropdown = ({ headerText, value, setValue, options }: DropdownProps) => {
    return (
        <div className='dropdown-container'>
            <label className='dropdown-header '>{headerText}</label>
            <select className='dropdown' value={value} onChange={(e) => setValue(e.target.value)}>
                {options.map((option) => {
                    return <option className='dropdown-option' key={option.id} value={option.id}>{option.value}</option>
                })}
            </select>
        </div>
    );
}