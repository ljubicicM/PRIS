import './styles/homePage.css';
import muzeji from '../assets/images/muzeji.jpg';

export const HomePage = () => {
    return (
        <div className='welcome-container-outer' >
            <div className='welcome-container'>
                <h1 className='welcome-title'>Welcome to Novi Sad</h1>
                <div className='welcome-container-inner'>
                    <p className='welcome-text'>Novi Sad, often referred to as the "Serbian Athens," is a city steeped in cultural
                        heritage and history, with its museums offering a fascinating glimpse into its richpast and vibrant present.
                        The museums in Novi Sad are treasure troves of artifacts, art, and historical records that collectively narrate
                        the story of this dynamic city.The Museum of Vojvodina, for example, is a comprehensive institution showcasing
                        over 400,000 artifacts from various periods, providing insights into the region's archeological, ethnographic,
                        and historical evolution. This museum's extensive collection includes everything from ancient Roman relics to
                        ethnographic displays of traditional costumes and everyday items used by the diverse communities that have
                        inhabited the region. Another notable institution is the Novi Sad City Museum, housed in the historic Petrovaradin
                        Fortress. This museum offers a unique blend of military history, art, and local history, with exhibits that detail
                        the fortress's strategic importance through the centuries, as well as its role in the city's development.
                        Art enthusiasts will find the Gallery of Matica Srpska particularly captivating, as it is one of the oldest and
                        most significant art galleries in Serbia, featuring a vast array of Serbian art from the 16th to the 20th centuries.
                        Its collections include works by prominent Serbian painters, offering a deep dive into the artistic movements that
                        have shaped the national cultural landscape. Additionally, the Pavle Beljanski Memorial Collection stands out for its
                        impressive assemblage of Serbian modern art, curated by the diplomat and collector Pavle Beljanski. His personal collection,
                        which includes masterpieces of Serbian modernism, reflects the cultural renaissance of Serbia during the first half of the
                        20th century. Together, these museums not only preserve and celebrate the cultural and historical legacy of Novi Sad but also
                        serve as dynamic cultural hubs that engage both locals and visitors through exhibitions, educational programs, and cultural
                        events. Exploring these museums provides an enriching experience, revealing the intricate tapestry of Novi Sad's past and present.
                    </p>
                    <img src={muzeji} alt="Muzeji Novog Sada" className='welcome-image'></img>
                </div>
            </div>
        </div>
    );
}