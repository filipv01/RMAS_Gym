package elfak.mosis.rmasfilipvidojkovic18108.screens

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var photoUri by remember { mutableStateOf<Uri?>(null) }
    var loading by remember { mutableStateOf(false) }
    var showSuccessMessage by remember { mutableStateOf(false) }

    val db = FirebaseFirestore.getInstance()
    val storage = FirebaseStorage.getInstance()
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            photoUri = uri
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF47555E)) // Set the background color here
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (loading) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Registering... Please wait")
        } else {
            if (showSuccessMessage) {
                Text(text = "Registration successful!", color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { navController.navigate("login") },
                        colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White, // Set button background to white
                    contentColor = Color.Black // Set button text color to black for contrast
                    )

                ) {
                    Text(text = "Go to Login")
                }
            } else {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )

                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = { Text("First Name") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = { Text("Last Name") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Phone Number") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant


                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { imagePickerLauncher.launch("image/*") },
                    modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White, // Set button background to white
                    contentColor = Color.Black // Set button text color to black for contrast
                    )
                ) {
                    Text("Pick Profile Photo")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (password == confirmPassword) {
                            loading = true
                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        val user = auth.currentUser
                                        val userId = user?.uid

                                        val profileData = hashMapOf(
                                            "username" to username,
                                            "firstName" to firstName,
                                            "lastName" to lastName,
                                            "phoneNumber" to phoneNumber,
                                            "email" to email,
                                            "points" to 0
                                        )

                                        if (userId != null) {
                                            db.collection("users").document(userId).set(profileData)
                                                .addOnCompleteListener { profileTask ->
                                                    if (profileTask.isSuccessful) {
                                                        photoUri?.let { uri ->
                                                            val storageRef = storage.reference.child("profile_photos/${UUID.randomUUID()}.jpg")
                                                            storageRef.putFile(uri)
                                                                .addOnSuccessListener {
                                                                    storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                                                                        db.collection("users").document(userId).update("photoUrl", downloadUrl.toString())
                                                                            .addOnSuccessListener {
                                                                                loading = false
                                                                                showSuccessMessage = true
                                                                            }
                                                                            .addOnFailureListener { exception ->
                                                                                loading = false
                                                                                Toast.makeText(context, "Photo URL save failed: ${exception.message}", Toast.LENGTH_LONG).show()
                                                                                Log.e("RegisterScreen", "Photo URL save failed", exception)
                                                                            }
                                                                    }
                                                                }
                                                                .addOnFailureListener { exception ->
                                                                    loading = false
                                                                    Toast.makeText(context, "Photo upload failed: ${exception.message}", Toast.LENGTH_LONG).show()
                                                                    Log.e("RegisterScreen", "Photo upload failed", exception)
                                                                }
                                                        } ?: run {
                                                            loading = false
                                                            showSuccessMessage = true
                                                        }
                                                    } else {
                                                        loading = false
                                                        val errorMessage = profileTask.exception?.message ?: "Unknown error"
                                                        Toast.makeText(context, "Profile save failed: $errorMessage", Toast.LENGTH_LONG).show()
                                                        Log.e("RegisterScreen", "Profile save failed", profileTask.exception)
                                                    }
                                                }
                                        } else {
                                            loading = false
                                            Toast.makeText(context, "Registration failed: User ID is null", Toast.LENGTH_LONG).show()
                                        }
                                    } else {
                                        loading = false
                                        val errorMessage = task.exception?.message ?: "Unknown error"
                                        Toast.makeText(context, "Registration failed: $errorMessage", Toast.LENGTH_LONG).show()
                                        Log.e("RegisterScreen", "Registration failed", task.exception)
                                    }
                                }
                        } else {
                            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White, // Set button background to white
                    contentColor = Color.Black // Set button text color to black for contrast
                    )

                ) {
                    Text("Register")
                }
            }
        }
    }
}
