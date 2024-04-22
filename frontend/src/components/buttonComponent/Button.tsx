declare interface ButtonProps {
    label?: string;
    imageUrl?: string;
    onClick?: () => void;
}

export const Button = ({ label, imageUrl, onClick }: ButtonProps) => {
    return (
        <div>
            <button onClick={() => onClick}>{label}</button>
        </div>
    );
};