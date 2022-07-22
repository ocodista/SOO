import { ShelfService } from '../services/ShelfService'
import type { NextPage } from 'next'
import type { EstanteType } from '../services/types'
import { Grid, GridItem } from '@chakra-ui/react'
import { Header } from '../components/Header/Header'
import { NicheArea } from '../components/Niche/NicheArea'
import { Shelf } from '../components/Shelf'
import { ResumeShelf } from '../components/Shelf/ResumeShelf'

interface IHome {
  estantes ?: EstanteType[]
}

const Home: NextPage = ({ estantes = [] }: IHome) => {
  return (
    <Grid
      templateAreas={`
        "header header"
        "main nav1"
        "main nav2"
        "footer nav2"
      `}
      templateRows="2fr 6fr 2fr 3fr"
      templateColumns="9fr 3fr"
      gap="0.5rem"
      padding="2rem"
      height="100%"
    >
      <GridItem area="header" height="fit-content">
        <Header />
      </GridItem>
      <GridItem area="main" alignItems="center">
        <NicheArea />
      </GridItem>

        <Shelf estantes={estantes} />
      <GridItem area="footer" bg='blue.300'>
        Footer
      </GridItem>
      <ResumeShelf />
    </Grid>
  )
}

export default Home

Home.getInitialProps = async (context) => {
  const estantes = await ShelfService.getAllShelfs()
  return { estantes }
}
