import "./textarea.css";

declare interface TextareaComponentProps {
    label: string;
    value: string;
    onChange: any;
    placeholder: string;
}


export const TextareaComponent = ({ label, value, onChange, placeholder }: TextareaComponentProps) => {
    return (
        <div className="textarea-container">
            <label className="textarea-label">{label}</label>
            <textarea className="textarea" value={value} onChange={onChange} placeholder={placeholder} />
        </div>
    );
};