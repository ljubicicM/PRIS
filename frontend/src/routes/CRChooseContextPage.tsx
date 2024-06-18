/* eslint-disable @typescript-eslint/no-unused-vars */
import { useLocation } from 'react-router-dom';
import './styles/routePages.css';
import { useContext, useState } from 'react';
import { MultipleCheckbox } from '../components/checkBoxComponent/MultipleCheckbox';
import { Dropdown } from '../components/dropdownComponent/dropdown';
import { Context } from '../context';
import { Textfield } from '../components/textFieldComponent/textfield';
import { Checkbox } from '../components/checkBoxComponent/CheckBox';
import { Button } from '../components/buttonComponent/Button';
import axios from 'axios';

export const CRChooseContextPage = () => {
    const state = useLocation();
    const [artPieces, setArtPieces] = useState(state.state.artPieces);
    const [time, setTime] = useState(state.state.time);
    const { userType, userId } = useContext(Context) as any;
    const [generality, setGenerality] = useState(1);
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [isVisable, setIsVisable] = useState(false);

    const createRouteString = (artPieces: any) => {
        let routeString = '';
        artPieces.forEach((artPiece: any) => {
            routeString += '===>' + artPiece.name;
        });
        return routeString;
    }

    const handlePDF = async () => {
        console.log(String(generality))
        await axios.post('http://localhost:8082/report/generateReport/', {
            artPieces: artPieces,
            routeGenerality: String(generality),
            minutes: String(Math.floor(time) % 60),
            hours: String(Math.floor(time / 60)),
            routeString: createRouteString(artPieces) as string,
        }, { responseType: 'arraybuffer' })
            .then((response) => {
                const pdf = new Blob([response.data], { type: 'application/pdf' });
                const url = URL.createObjectURL(pdf);
                const tempLink = document.createElement('a');
                tempLink.href = url;
                tempLink.setAttribute('download', 'route.pdf');
                document.body.appendChild(tempLink);
                tempLink.click();
                document.body.removeChild(tempLink);
                window.URL.revokeObjectURL(url);
            })
    }
    const handleSaveRoute = async () => {
        await axios.post('http://localhost:8082/route/saveRoute', {
            userId: userId,
            artPieces: artPieces,
            routeName: name,
            routeDescription: description,
            routeDuration: time,
            routeVisibility: isVisable,
        })
            .then((response) => {
                if (response.data !== null && response.data) {
                    alert('Route saved successfully')
                }
            }).catch((error) => {
                alert('Route not saved')
                console.log(error)
            })

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
                            <Button label='Save route' size='medium' isEnabeld={name !== "" && description !== ""} onClick={handleSaveRoute} />
                        </div>
                    </div>
                    : <></>}
            </div>
        </div>
    );
}