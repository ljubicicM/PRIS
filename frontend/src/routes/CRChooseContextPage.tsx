import { useLocation, useNavigate } from 'react-router-dom';
import './styles/routePages.css';
import { useContext, useEffect, useState } from 'react';
import { MultipleCheckbox } from '../components/checkBoxComponent/MultipleCheckbox';
import { Dropdown } from '../components/dropdownComponent/dropdown';
import { Context } from '../context';
import { Textfield } from '../components/textFieldComponent/textfield';
import { Checkbox } from '../components/checkBoxComponent/CheckBox';
import { Button } from '../components/buttonComponent/Button';

export const CRChooseContextPage = () => {
    const navigate = useNavigate();
    const state = useLocation();
    const [artPieces, setArtPieces] = useState(state.state.artPieces);
    const [time, setTime] = useState(state.state.time);
    const { userType } = useContext(Context) as any;
    const [generality, setGenerality] = useState(1);
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [isVisable, setIsVisable] = useState(false);

    const handlePDF = () => {

    }

    const handleSaveRoute = () => {
    }

    return (
        <div className='route-create-container-outer'>
            <div className="route-create-container">
                <h1>Choose context and generality</h1>
                <h2>The context you choose will be shown in your guide</h2>
                <div className="route-create-context-container" >
                    {artPieces.map((artPiece: any, index: number) => {
                        return (
                            <div key={index} className="route-create-context">
                                <h3 className='route-create-context-title'>{artPiece.name}</h3>
                                <MultipleCheckbox artPieces={artPieces} index={index} setArtPieces={setArtPieces} />
                            </div>
                        );
                    }
                    )}
                </div>
                <div className='route-create-pdf-container'>
                    <Dropdown value={generality} handleChange={setGenerality} headerText='Generality'
                        options={[{ id: 1, value: "Local Tourist" }, { id: 2, value: "Serbian Tourist" }, { id: 3, value: "European Tourist" }]} />
                    <h1 className='route-create-pdf-text' onClick={() => handlePDF()}>Generate PDF guide</h1>
                </div>
                {userType === "admin" || userType === "tourist" ?
                    <div className='route-create-save-container'>
                        <div className='route-create-save-input'>
                            <Textfield value={name} setValue={setName} headerText='Route name' placeholder='Route name' />
                            <Textfield value={description} setValue={setDescription} headerText='Route description' placeholder='Route description' />
                            <br></br>
                            <Checkbox val={isVisable} setValue={setIsVisable} label='Make route globaly visable' name='isVisable' />
                        </div>
                        <div className='route-create-save-button'>
                            <Button label='Save route' size='medium' onClick={handleSaveRoute()} />
                        </div>
                    </div>
                    : <></>}
            </div>
        </div>
    );
}