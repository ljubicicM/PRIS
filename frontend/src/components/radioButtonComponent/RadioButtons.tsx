import './style.css';

declare interface RadioButtonsProps {
    labels: string[];
    name: string;
    handleChange?: any;
}

export const RadioButtons = ({ labels, name, handleChange }: RadioButtonsProps) => {
    const children = labels.map((label, index) => {
        return (
            <div className='radio-button' key={index} >
                <input className='radio' type="radio" name={name} value={label} onChange={handleChange} />
                <h1 className='radio-text'>{label}</h1>
            </div>
        )
    });
    return (
        <div className='radio-button-container'>
            {children}
        </div>
    )
}