import React from 'react';
import './styles/routePages.css';
import { Dropdown } from '../components/dropdownComponent/dropdown';
export const CRSearchByPage = () => {
    const [dropdownValue, setDropdownValue] = React.useState(0);

    const handleChange = (value: number) => {
        setDropdownValue(value);
        console.log(value);
    }
    const testArr = [
        { id: 0, value: 'Select Origin' },
        { id: 1, value: 'Origin 1' },
        { id: 2, value: 'Origin 2' },
        { id: 3, value: 'Origin 3' },
        { id: 4, value: 'Origin 4' },
        { id: 5, value: 'Origin 5' },
        { id: 6, value: 'Origin 6' },
        { id: 7, value: 'Origin 7' },
    ]
    return (
        <div className='route-create-container-outer'>
            <div className="route-create-container">
                <h1>Create Route</h1>
                <Dropdown headerText='Origin' value={dropdownValue} setValue={handleChange} options={testArr} />
            </div>
        </div>
    );
}