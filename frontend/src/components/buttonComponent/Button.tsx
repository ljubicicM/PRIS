import './style.css';

declare interface ButtonProps {
    label?: string;
    imageUrl?: string;
    onClick?: () => void;
    size?: string;
}

export const Button = ({ label, imageUrl, onClick, size = 'small' }: ButtonProps) => {
    if (imageUrl) {
        return (
            <div className='button-container'>
                <button className={size === 'small' ? 'button small' : 'button large'} onClick={() => onClick}>
                    <img src={imageUrl} alt=''></img>
                </button>
            </div>
        )
    } else {
        return (
            <div className='button-container'>
                <button className={size === 'small' ? 'button small' : 'button large'} onClick={() => onClick}>{label}</button>
            </div>
        );
    }
};