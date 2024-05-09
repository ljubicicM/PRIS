import './style.css';

declare interface TextfieldProps {
    value: string;
    setValue: any;
    headerText: string;
    placeholder: string;
    size?: string;
}

export const Textfield = ({ value, setValue, headerText, placeholder, size = 'large' }: TextfieldProps) => {
    return (
        <div>
            <h1 className='textfield-header'>{headerText}</h1>
            <div className={`textfield-container ${size}`} >
                <input value={value} onChange={e => setValue(e.target.value)} type='email' placeholder={placeholder} className={`textfield ${size}`} />
            </div>
        </div>
    )
}
