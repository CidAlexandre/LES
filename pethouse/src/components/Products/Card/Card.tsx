import 'styles/card.scss';

type CardProps = {
    productId: string;
    productName: string;
    productAmount: string;
    productImageUrl: any
}

export function ProductCard(props : CardProps){
    return(
        <div id = "card">
            <img className="card-img" src = {props.productImageUrl}  alt = {props.productName}/> 
            <div>
            <h2><b>{props.productName}</b></h2>    
            
               <span className = "price"> R$ {props.productAmount} </span>
            </div>
        </div>
        )
}