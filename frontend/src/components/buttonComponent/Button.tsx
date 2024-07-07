import './style.css';

declare interface ButtonProps {
    label?: string;
    imageUrl?: string;
    onClick?: any;
    size?: string;
    isEnabeld?: boolean;
}

export const Button = ({ label, imageUrl, onClick, size = 'small', isEnabeld }: ButtonProps) => {
    if (imageUrl) {
        return (
            <div className='button-container'>
                <button disabled={!isEnabeld} className={size === 'small' ? 'button small' : 'button large'} onClick={() => onClick}>
                    <img src={imageUrl} alt=''></img>
                </button>
            </div>
        )
    } else {
        return (
            <div className='button-container'>
                <button disabled={!isEnabeld} className={size === 'small' ? 'button small' : 'button large'} onClick={onClick}>{label}</button>
            </div>
        );
    }
};