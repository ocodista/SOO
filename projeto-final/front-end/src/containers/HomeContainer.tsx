import { Grid, GridItem } from '@chakra-ui/react'
import { NicheArea } from '../components/Bookcase/NicheArea'
import { Header } from '../components/Header/Header'

export function HomeContainer () {
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
        gap="8px"
        padding="32px"
        height="100%"
      >
      <GridItem area="header" height="fit-content">
        <Header />
      </GridItem>
      <GridItem
        area="main"
        alignItems="center"
      >
        <NicheArea />
      </GridItem>
      <GridItem area="nav1" bg='green.300' >
        Nav1
      </GridItem>
      <GridItem area="footer" bg='blue.300'>
        Footer
      </GridItem>
      <GridItem area="nav2" bg='green.800'>
        Nav2
      </GridItem>
    </Grid>
  )
}
