package com.example.jetpackcomposedemo

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun AppBottomNavigationView(
    navController: NavController
) {
    val navItems = listOf(NavItem.Home, NavItem.Fav, NavItem.Feed, NavItem.Profile)

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = "") },
                label = { Text(text = stringResource(id = item.title)) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                selected = currentRoute == item.navRoute,
                onClick = {
                    navController.navigate(item.navRoute)
                }
            )
        }
    }
}