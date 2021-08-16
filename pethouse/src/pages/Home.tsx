import { Link } from 'react-router-dom';
import logoImg from 'assets/images/logo.svg';
import { ProductCard } from 'components/Products/Card/Card'

export function Home(){
    return(
        <div>
            <h1>Navegacao</h1>
            <div>
                <ProductCard productImageUrl = "https://www.petlove.com.br/images/products/224974/product/Ração_Seca_Pedigree_para_Cães_Adultos_Raças_Pequenas_3104845.jpg?1627721469" 
                productId = "asdsad"
                productName = "Ração Pedigree 15kg" 
                productAmount = "120,00" />
            </div>
        </div>
    )
}