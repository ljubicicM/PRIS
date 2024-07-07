import './style.css';

declare interface RadioButtonsProps {
    labels: string[];
    name: string;
    setValue?: any;
}

export const RadioButtons = ({ labels, name, setValue }: RadioButtonsProps) => {
    const handleChange = (e: any) => {
        setValue(e.target.value);
    }
    const children = labels.map((label, index) => {
        return (
            <div className='radio-button' key={index}  >
                <input className='radio' type="radio" name={name} value={label} onChange={(e) => handleChange(e)} />
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