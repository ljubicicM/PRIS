import './style.css';

declare interface TextfieldProps {
    headerText: string;
    placeholder: string;
    size?: string;
}

export const Textfield = ({ headerText, placeholder, size = 'large' }: TextfieldProps) => {
    return (
        <div>
            <h1 className='textfield-header'>{headerText}</h1>
            <div className={`textfield-container ${size}`} >
                <input type='email' placeholder={placeholder} className={`textfield ${size}`} />
            </div >
        </div>
    )
}
